# NIO-info 简介
```text
 全称: non-blocking IO,也称为 new io 即 NIO
 NIO是面向缓冲区,或者面向块的编程
```


## NIO-three cores 三大核心
```text
1: channel 通道(channel是双向的),目标通道和当前通道的区分
2: buffer 缓冲区(在非阻塞方面有关键的作用;buffer是一个内存块,底层有一个数组;数据的读取和写入通过buffer,通过flip进行切换)
3: selector 选择器(选择通道由event事件决定)

relation
一个thread 对应 一个selector, 一个selector 对应 多个channel,  一个channel 对应 多个buffer
```
