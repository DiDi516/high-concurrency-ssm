<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数</title>
    <script src="/static/lib/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        $(function () {
            //模拟30000个异步请求，进行并发
            var max = 30000;
            for(var i = 1 ; i <= max ;i++){
                //jquery 的post请求，异步请求
                $.post({
                    url:"./userRedPacket/grapRedPacket.do?redPacketId=1&userId="+i,
                    success:function(result){

                    }
                });
            }
        });
    </script>
</head>
<body>

</body>
</html>
