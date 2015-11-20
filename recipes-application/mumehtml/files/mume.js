var xhttp = new XMLHttpRequest()

function readValues() {
  xhttp.open('GET', 'mume/xml', true); 
  xhttp.onreadystatechange = displayContents;
  xhttp.send(null);
}

function displayContents() {
  if(xhttp.readyState==4) {
    var response = xhttp.responseXML;
    for (var entry = response.documentElement.firstChild; entry != null; entry = entry.nextSilbling) {
      var name = entry.nodeName;
      var value = entry.getAttribute('state');
      var el = document.getElementById(name);
      el.innerHTML = value;
    }
  }
}

function writeValues() {
  var value = document.getElementById('openPositionMs').value;

  xhttp.open('POST', 'mume/xml', true);
  xhttp.setRequestHeader("Content-type", "application/xml");
  xhttp.send("<mume><openPositionMs value=\"" + value + "\"/></mume>");
}

