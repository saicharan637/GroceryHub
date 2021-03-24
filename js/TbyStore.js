//This method will parse json data and build datatable required by google api to plot the bar chart.
$("#btnGetHeatmap2").click(function () {
    $.ajax({
        url: "HeatMap",
        type: "POST",
        data: "{}",
        success: function (msg) {
            initMap(msg)            
        },
        error: function(){
            console.log("error occurred while making ajax call;")
        }
    });    
 });
 
 var map, heatmap;	
 function initMap(jsonData) {
    var parsedData = $.parseJSON(jsonData);
    // console.log(parsedData);
 //    var latitude = new Array();
 //    var longitude = new Array();
    var data = new Array()
    
    for(var i=0; i<parsedData.length; i++) {
        var temp1 = parsedData[i]["lat"];
        var temp2 = parsedData[i]["longi"];
        var temp3 = parsedData[i]["weight"];
 
        data.push({location: new google.maps.LatLng(temp1, temp2), weight: temp3});
     }
     console.log("data is",data)
     // console.log(JSON.parse(undefined))
     localStorage.clear()
     drawChart(data);
 }
 
 
 //Plot the chart using 2d array and product names as subtitles;
 function drawChart(heatmapData) {   
 
     var chicago = new google.maps.LatLng(41.881832,-87.623177);
 
     map = new google.maps.Map(document.getElementById('heat_div'), {
         center: chicago,
         zoom: 13,
         mapTypeId: 'satellite'
     });
     
     heatmap = new google.maps.visualization.HeatmapLayer({
         data: heatmapData
     });

     const contentString5 ='Store Zip: 60353';
const infowindow5 = new google.maps.InfoWindow({
    content: contentString5,
});
const marker5 = new google.maps.Marker({
    position: { lat: 41.853586, lng: -87.628960},
    map,
});
marker5.addListener("click", () => {
    infowindow5.open(map, marker5);
});

const contentString6 ='Store Zip: 60621';
const infowindow6 = new google.maps.InfoWindow({
    content: contentString6,
});
const marker6 = new google.maps.Marker({
    position: { lat: 41.849457, lng: -87.634873},
    map,
});
marker6.addListener("click", () => {
    infowindow6.open(map, marker3);
});


const contentString1 ='Store Zip: 60051';
const infowindow1 = new google.maps.InfoWindow({
    content: contentString1,
});
const marker1 = new google.maps.Marker({
    position: { lat: 41.862159, lng: -87.650808},
    map,
});
marker1.addListener("click", () => {
    infowindow1.open(map, marker1);
});

const contentString2 ='Store Zip: 600345';
const infowindow2 = new google.maps.InfoWindow({
    content: contentString2,
});
const marker2 = new google.maps.Marker({
    position: { lat: 41.821659, lng: -87.618667},
    map,
});
marker2.addListener("click", () => {
    infowindow2.open(map, marker2);
});

const contentString3 ='Store Zip: 60134';
const infowindow3 = new google.maps.InfoWindow({
    content: contentString3,
});
const marker3 = new google.maps.Marker({
    position: { lat: 41.883927, lng: -87.625694},
    map,
});
marker3.addListener("click", () => {
    infowindow3.open(map, marker3);
});

     heatmap.setMap(map);
 }
 
 function toggleHeatmap() {
   heatmap.setMap(heatmap.getMap() ? null : map);
 }
 