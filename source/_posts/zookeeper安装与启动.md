---
title: zookeeper安装与启动
date: 2022-12-20 15:24:38
tags:
categories:

- Linux

---

1、zookeeper的下载  
官网 [下载地址](https://zookeeper.apache.org/releases.html)
![](../images/0012/20221220152700.png)
>  wget --no-check-certificate https://dlcdn.apache.org/zookeeper/zookeeper-3.6.3/apache-zookeeper-3.6.3-bin.tar.gz
> 

2、解压压缩包
>tar -zxvf apache-zookeeper-3.6.3-bin.tar.gz -C /usr/local/

3、进入zookeeper的安装目录下
* 创建data目录，存放我们的数据，使用以下命令
> cd /usr/local/apache-zookeeper-3.6.3-bin
> mkdir data
> 

4、进入conf目录，修改文件名称
* 把zoo_sample.cfg 改名为zoo.cfg。可以复制一份，重命名为zoo.cfg（默认配置名称）
> #进入conf目录
> cd conf/
> #复制一份，名为zoo.cfg
> cp zoo_sample.cfg zoo.cfg

5、修改zoo.cfg配置文件
* 将dataDir修改为我们自己创建的data目录
![](../images/0012/20221220153614.png)

6、启动测试
* 进入zookeeper目录下的bin目录,使用命令启动zkServer.sh,后缀为sh的为linux启动，为cmd的是Windows下启动
> ./zkServer.sh start

* 启动后查看服务的状态，显示如下信息则启动成功
> ./zkServer.sh status
![](../images/0012/20221220153906.png)

* 停止服务
> ./zkServer.sh stop
![](../images/0012/20221220154048.png)

