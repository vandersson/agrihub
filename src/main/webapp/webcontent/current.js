function getCurrent(onReady) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            onReady(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", window.location.href, true);
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.send();
}


function update() {
    getCurrent(function (data) {
        document.getElementById("temp").innerHTML = data.temperature;
        document.getElementById("ligh").innerHTML = data.light;
        document.getElementById("moi").innerHTML = data.moisture;
        window.gauge1.update(data.moisture);
    });
    setTimeout(function () {
        update();
    }, 5000);
}

function moistureWidget(name) {
    var config1 = liquidFillGaugeDefaultSettings();
    config1.circleColor = "#006633";
    config1.textColor = "#006633";
    config1.waveTextColor = "#CCDDCC";
    config1.waveColor = "#006633";
    config1.waveAnimateTime = 4000;
    config1.waveHeight = 0.1;
    config1.waveRise = false;
    config1.waveHeightScaling = false;
    config1.waveOffset = 0.25;
    window.gauge1 = loadLiquidFillGauge(name, 50, config1);
}