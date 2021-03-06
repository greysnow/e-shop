<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <link rel="icon" href="https://jscdn.com.cn/highcharts/images/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1">	<script src="https://img.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script src="https://img.highcharts.com.cn/highcharts/modules/exporting.js"></script>
    <script src="https://img.highcharts.com.cn/highcharts/modules/series-label.js"></script>
    <script src="https://img.highcharts.com.cn/highcharts/modules/oldie.js"></script>
    <script src="https://img.highcharts.com.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
</head>
<body>
<!--
*************************************************************************
   Generated by JShare at 2019-04-13 13:32:57
   From: https://jshare.com.cn/demos/hhhhxL
*************************************************************************
 -->
<div id="container" style="max-width:800px;height:400px"></div>
<script>
    var chart = Highcharts.chart('container', {
        title: {
            text: '2018.11 ~ 2019.04 运动鞋销售情况及预测'
        },
        subtitle: {
            text: '数据来源：运动鞋销售管理系统'
        },
        yAxis: {
            title: {
                text: '销售量'
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },
        plotOptions: {
            series: {
                label: {
                    connectorAllowed: false
                },
                pointStart: 1
            }
        },
        series: [{
            name: 'Nike UR',
            data: [65, 77, 82, 107, 122, 128, 151]
        }, {
            name: 'Nike SR',
            data: [40, 40, 50, 55, 60, 60, 69]
        }, {
            name: 'Kappa K2',
            data: [40, 40, 50, 60, 60, 70, 79]
        }, {
            name: 'Kappa K8',
            data: [61, 65, 76, 78, 94, 99, 110]
        }, {
            name: 'LINING WARNING',
            data: [60, 65, 65, 70, 70, 75, 76]
        }, {
            name: 'LINING Ranger',
            data: [50, 50, 55, 55, 60, 65, 68]
        }],
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });</script>
</body>
</html>