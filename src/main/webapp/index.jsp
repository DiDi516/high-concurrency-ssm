<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>参数</title>
    <script src="/static/lib/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        function batchSend() {
            //模拟30000个异步请求，进行并发
            var max = 30000;
            for (var i = 1; i <= max; i++) {
                //jquery 的post请求，异步请求
                $.ajax({
                    type: "POST",
                    url: "./userRedPacket/grapRedPacket.do?redPacketId=1&userId=" + i,
                    success: function (result) {
                    },
                    dataType: "text"
                });
            }
        }

        function send() {
            $.ajax({
                type: "POST",
                url: "./userRedPacket/grapRedPacket.do?redPacketId=1&userId=1",
                success: function (result) {
                    console.log("click..." + result);
                },
                dataType: "text"
            });
        }
    </script>
</head>
<body>
<button onclick="send();">抢一次红包</button>
<br/>
<button onclick="batchSend();">并发30000次抢红包</button>
</body>
</html>
