

$(document).ready(function(){
    let items = 0;

addItem = function (){

	items++;
	console.log(items)
document.getElementById("counter").innerHTML = items;
}
});