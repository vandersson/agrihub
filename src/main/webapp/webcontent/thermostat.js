function setTemperature(element_id, value) {
    var input_max = 55;
    var input_min = -20;
    var transform_min = 512;
    var transform_max = 0;
    var height_min = 2;
    var height_max = 76;

    value = value > input_max ? input_max : value;
    value = value < input_min ? input_min : value;


    var mapper = mapValues(value, input_min, input_max);
    var transform_val = mapper(transform_min, transform_max);
    var height_val = mapper(height_min, height_max);

    var element_style = document.getElementById(element_id).style;

    element_style.transform = "translateY(" + transform_val + "px)";
    element_style.height = height_val + '%';

}


function mapValues(x, in_min, in_max)
{
    return function(out_min, out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
