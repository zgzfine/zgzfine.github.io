---
title: linux服务启动脚本
date: 2022-12-15 15:48:00
tags:
categories:

- Linux

---

在linux系统部署服务(如java进程)，难免会使用shell脚本，下面就以centos7、rocketmq为例子，简单介绍。

<!--more-->

1、编写shell脚本
```
#!/bin/sh
#
# rocketmq - this script starts and stops the rocketmq daemon
#
# chkconfig: - 85 15
# 假如java环境变量
# export JAVA_HOME='这里写上自己安装jdk的目录路径 例如：/usr/lib/jvm/jre-1.8.0'
# export PATH=$JAVA_HOME/bin:$PATH

ROCKETMQ_HOME=/usr/local/rocketmq-all-4.8.0-bin-release
ROCKETMQ_BIN=${ROCKETMQ_HOME}/bin
ADDR=$(hostname -i):9876
# 这里写上自己服务器的ip地址以及端口号 例如：192.168.0.1:9876
BROKER_IP=localhost:9876
LOG_DIR=${ROCKETMQ_HOME}/logs
NAMESERVER_LOG=${LOG_DIR}/namesrv.log
BROKER_LOG=${LOG_DIR}/broker.log

start() {
  if [ ! -d ${LOG_DIR} ]; then
    mkdir ${LOG_DIR}
  fi
  cd ${ROCKETMQ_HOME}
  nohup sh bin/mqnamesrv >${NAMESERVER_LOG} 2>&1 &
  echo -n "The Name Server boot success..."
  nohup sh bin/mqbroker -n ${BROKER_IP} >${BROKER_LOG} 2>&1 &
  echo -n "The broker[%s, ${BROKER_IP}] boot success..."
}
stop() {
  cd ${ROCKETMQ_HOME}
  echo -n "The Name Server boot is stopping..."
  sh bin/mqshutdown broker
  sleep 1
  echo -n "The broker[%s, ${BROKER_IP}] boot is stopping..."
  sh bin/mqshutdown namesrv
}
restart() {
  stop
  sleep 5
  start
}

case "$1" in
start)
  start
  ;;
stop)
  stop
  ;;
restart)
  restart
  ;;
*)
  echo $"Usage: $0 {start|stop|restart}"
  exit 2
  ;;
esac

```
编写完shell脚本，可以使用 rz 命令传送到服务器（安装命令：sudo yum install lrzsz）
记得需要赋予系统的执行权限 chmod 777 xxx.sh (r、w、x、-表示4、2、1、0)

2、编写服务service脚本
```
[Unit]
Description=rocketmq shell script
After=network.target
 
[Service]
Type=forking
ExecStart=/usr/local/rocketmq-all-4.8.0-bin-release/rocketmq.sh start
ExecStop=/usr/local/rocketmq-all-4.8.0-bin-release/rocketmq.sh stop
ExecReload=/usr/local/rocketmq-all-4.8.0-bin-release/rocketmq.sh restart
Restart=always
RestartSec=5
 
[Install]
WantedBy=multi-user.target
```

文件上传到服务器的这个目录：/usr/lib/systemd/system
此时就可以使用systemctl status xxx.service
执行开机启动 systemctl enable  xxx.service
关闭开机启动 systemctl disable  xxx.service

3、systemed的使用
* systemd即为systemd daemon，是Linux下的一个init软件，由Lennart Poettering带头开发，并在LGPL2.1及其后续版本许可证下开源发布，开发目标是提供更优秀的框架以表示系统服务间的依赖关系，并以此来实现系统初始化时服务的并行启动，同时到达降低shell的系统开销的效果，最终代替常用的system V与BSD风格initial程序。
* 熟悉linux的都知道init是centos6及6以前用来管理服务和软件的方式，从centos7到现在的redhat9(因为centos9还没出)都是使用的systemd来控制

4、service配置文件详解
对于某些支持systemd的服务而言，他们的service文件一般都放在/usr/lib/systemd/system目录下
如果我们设置了某个服务开机自启，那么系统就在/etc/systemd/system目录添加来一个符号链接(或者说软链接)，指向/usr/lib/systemd/system里面对应服务service文件。
当你设置禁止开机自启的时候系统就会自动删除/etc/systemd/system/multi-user.target.wants目录下的链接文件
因为系统在开机时，systemd只执行/etc/systemd/system

* 查看服务状态
```
[root@localhost ~]# systemctl status docker.service
● docker.service - Docker Application Container Engine
Loaded: loaded (/usr/lib/systemd/system/docker.service; enabled; vendor preset: disabled)
Active: active (running) since Tue 2022-08-30 19:23:50 CST; 3h 3min ago
Docs: https://docs.docker.com
Main PID: 1308 (dockerd)
Tasks: 8
Memory: 118.1M
CGroup: /system.slice/docker.service
└─1308 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
loaded：配置文件所在位置，后面的一个参数表示是否为开机自启
Active：表示正在运行
Main PID：表示主进程的PID号
Status：由应用本身提供的软件当前状态，但是docker没有提供这个参数
CGroup：应用所有的子进程
CGroup下面的都是应用的日志信息

```

* Unit栏：启动顺序与依赖关系
```
Description字段是当前服务的简单描述
Documentation字段给出命令帮助文档位置
After字段表示如果network.target或sshd-kegen.service需要启动，那么sshd.service要在他们之后启动。
Before字段定义sshd.service应该在哪些服务之前启动(这里没有，可以自行设置)
Wants字段表示sshd.service与sshd-keygen.service之间存在"弱依赖"关系，即如果sshd-keygen.service启动失败或停止运行，不影响sshd.service继续执行。
Requires字段表示"强依赖"关系，即如果该服务启动失败或异常退出，那么sshd.service也必须退出。
Wants字段与Requires字段只涉及依赖关系，与启动顺序无关，默认情况下是同时启动的。
BindsTo字段与Requires类似，它指定的unit如果退出，会导致当前unit停止运行
Conflicts：与此栏有冲突的模块，如果列出模块中有已经运行的，这个服务就不能启动，反之亦然。
OnFailure：当这个模块启动失败时，就自动启动列出的每个模块。
Assert字段：当前unit运行必须满足的条件，否则会报启动失败
```

* Service栏：启动行为
```
EnvironmentFile字段：指定当前服务的环境参数文件。该文件内部的key=value键值对，可以用$key的形式，在当前配置文件中获取。
ExecStart字段：定义启动进程时执行的命令，在service文件中$OPTIONS变量表示的是EnvironmentFile字段指定的环境参数文件
ExecReload字段：重启服务时执行的命令，$MAINPID变量表示的服务主进程的PID号
ExecStop字段：停止服务时执行的命令
ExecStartPre字段：启动服务前执行的命令
ExecStopPost字段：停止服务后执行的命令
ExecStartPost字段：启动服务后执行的命令
RestartSec: 如果服务需要被重启，这个参数的值为服务被重启前的等待秒数。注意，该重启等待时间只针对Restart的参数值起作用时的重启才有效，因Unit段配置的关系或者人为使用systemctl restart命令导致该服务重启时，则无效。
TimeoutSec：定义systemd停止当前服务之前等待的秒数
Environment：指定环境变量
Nice:服务的进程优先级，值越小优先级越高，默认为0。-20为最高优先级，19为最低优先级
WorkingDirectory:指定服务的工作目录
RootDirectory:指定服务进程的根目录，如果配置了这个参数后，服务将无法访问指定目录以外的任何文件。
User:指定运行服务的用户，会影响服务对本地文件系统的访问权限。可使用root
Group:指定运行服务的用户组，会影响服务对本地文件系统的访问权限。
PrivateTmp:是否给服务分配独立的临时空间(tru/false)
Restart字段：指定什么情况下需要重启服务进程，这个不同的值表示哪些情况下，服务会被重新启动：
no：退出后不会重启
always：除了用systemctl stop或等价的服务停止操作命令，其他情况下都可以重启
on-success：只有正常退出时(退出状态码为0)，才会重启
on-failure：非正常退出时(退出状态码不为0)，包括被信号终止和超时，才会重启
on-abnormal：只有被信号终止和超时，才会重启(一般用用于允许发生错误的服务)
on-abort：只有在收到没有捕捉到的信号终止时，才会重启
on-watchdog：超时退出，才会重启
```

* 启动类型
```
type字段定义启动类型。
simple(默认值)：ExecStart字段启动的进程为主进程
forking：ExecStart字段将以fork()方式启动，此时父进程将退出，子进程将称成为主进程
oneshot：类似simple，但只执行一次，Systemd会等他执行完，才会启动其他服务
dbus：类似于simple，但会等待D-Bus信号后启动
notify：类似于simple，启动结束后会发出通知信号，然后Systemd再启动其他服务
idle：类似于simple，但是要等到其他任务都执行完，才会启动该服务。一种使用场合是为了让该服务的输出，不与其他服务的输出相混合

```