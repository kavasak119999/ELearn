var url = window.location.href;
let button = document.getElementById("button");
if (url.indexOf('?result') != -1) {
    button.setAttribute("style","visibility: visible");
}