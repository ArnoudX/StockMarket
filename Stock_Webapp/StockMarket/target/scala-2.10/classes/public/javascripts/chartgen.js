var chartData = [
    {"date":"2014-09-17","value":"58.89"},
    {"date":"2014-09-18","value":"58.4"},
    {"date":"2014-09-19","value":"58.25"},
    {"date":"2014-09-22","value":"57.55"},
    {"date":"2014-09-23","value":"56.98"}
];       

        
AmCharts.ready(function() {
    var chart = new AmCharts.AmStockChart();
    chart.pathToImages = "http://www.amcharts.com/lib/3/images/";
    
    var dataSet = new AmCharts.DataSet();
    dataSet.dataProvider = chartData;
    dataSet.fieldMappings = [{fromField:"value", toField:"value2"}];   
    dataSet.categoryField = "date";          
    chart.dataSets = [dataSet];
    
    var stockPanel = new AmCharts.StockPanel();
    chart.panels = [stockPanel];
    
    var panelsSettings = new AmCharts.PanelsSettings();
    panelsSettings.startDuration = 1;
    chart.panelsSettings = panelsSettings;   
    
    var graph = new AmCharts.StockGraph();
    graph.valueField = "value2";
    graph.type = "line";
    graph.bullet = "round";
    graph.lineColor = "#0066CC";
    graph.title = "Company Stock Chart Data"; 
    stockPanel.addStockGraph(graph);
    
    chart.write("chartdiv");
});
                
$(document).ready(function(){
    $("#magie").click(function(){
        $("#chartdiv").toggle();
    });
});