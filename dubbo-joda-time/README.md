# Dubbo Joda Time Demo

Demo to show that Dubbo `hessian2` serialization does not support Joda Time.

`java` serialization does not have this problem.

Related issue: [https://github.com/apache/incubator-dubbo/issues/126]()

## Run

Just start `com.example.Provider` and `com.example.Consumer`

## Sample output

    WARNING:  [DUBBO] Decode rpc result failed: org.joda.time.base.BaseDateTime.iChronology: 'org.joda.time.Chronology' could not be instantiated, dubbo version: 2.6.2, current host: 192.168.3.5
    com.alibaba.com.caucho.hessian.io.HessianFieldException: org.joda.time.base.BaseDateTime.iChronology: 'org.joda.time.Chronology' could not be instantiated
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer.logDeserializeError(JavaDeserializer.java:167)
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer$ObjectFieldDeserializer.deserialize(JavaDeserializer.java:412)
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer.readObject(JavaDeserializer.java:276)
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer.readObject(JavaDeserializer.java:203)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObjectInstance(Hessian2Input.java:2808)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2146)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2075)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2119)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2075)
    	at com.alibaba.dubbo.common.serialize.hessian2.Hessian2ObjectInput.readObject(Hessian2ObjectInput.java:91)
    	at com.alibaba.dubbo.common.serialize.hessian2.Hessian2ObjectInput.readObject(Hessian2ObjectInput.java:96)
    	at com.alibaba.dubbo.rpc.protocol.dubbo.DecodeableRpcResult.decode(DecodeableRpcResult.java:83)
    	at com.alibaba.dubbo.rpc.protocol.dubbo.DecodeableRpcResult.decode(DecodeableRpcResult.java:113)
    	at com.alibaba.dubbo.rpc.protocol.dubbo.DubboCodec.decodeBody(DubboCodec.java:89)
    	at com.alibaba.dubbo.remoting.exchange.codec.ExchangeCodec.decode(ExchangeCodec.java:124)
    	at com.alibaba.dubbo.remoting.exchange.codec.ExchangeCodec.decode(ExchangeCodec.java:84)
    	at com.alibaba.dubbo.rpc.protocol.dubbo.DubboCountCodec.decode(DubboCountCodec.java:46)
    	at com.alibaba.dubbo.remoting.transport.netty.NettyCodecAdapter$InternalDecoder.messageReceived(NettyCodecAdapter.java:133)
    	at org.jboss.netty.channel.SimpleChannelUpstreamHandler.handleUpstream(SimpleChannelUpstreamHandler.java:80)
    	at org.jboss.netty.channel.DefaultChannelPipeline.sendUpstream(DefaultChannelPipeline.java:564)
    	at org.jboss.netty.channel.DefaultChannelPipeline.sendUpstream(DefaultChannelPipeline.java:559)
    	at org.jboss.netty.channel.Channels.fireMessageReceived(Channels.java:274)
    	at org.jboss.netty.channel.Channels.fireMessageReceived(Channels.java:261)
    	at org.jboss.netty.channel.socket.nio.NioWorker.read(NioWorker.java:349)
    	at org.jboss.netty.channel.socket.nio.NioWorker.processSelectedKeys(NioWorker.java:280)
    	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:200)
    	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
    	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:44)
    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    	at java.lang.Thread.run(Thread.java:748)
    Caused by: com.alibaba.com.caucho.hessian.io.HessianProtocolException: 'org.joda.time.Chronology' could not be instantiated
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer.instantiate(JavaDeserializer.java:316)
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer.readObject(JavaDeserializer.java:201)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObjectInstance(Hessian2Input.java:2808)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2146)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2075)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2119)
    	at com.alibaba.com.caucho.hessian.io.Hessian2Input.readObject(Hessian2Input.java:2075)
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer$ObjectFieldDeserializer.deserialize(JavaDeserializer.java:408)
    	... 29 more
    Caused by: java.lang.InstantiationException
    	at sun.reflect.InstantiationExceptionConstructorAccessorImpl.newInstance(InstantiationExceptionConstructorAccessorImpl.java:48)
    	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
    	at com.alibaba.com.caucho.hessian.io.JavaDeserializer.instantiate(JavaDeserializer.java:312)
    	... 36 more
