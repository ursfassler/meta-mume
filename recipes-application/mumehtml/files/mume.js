var URI = 'mume/xml';
var xhttp = new XMLHttpRequest()

function readValues() {
  xhttp.open('GET', URI, true); 
  xhttp.onreadystatechange = displayContents;
  xhttp.send(null);
}

function displayContents() {
  if(xhttp.readyState==4) {
    var response = xhttp.responseXML;
    for (var entry = response.documentElement.firstChild; entry != null; entry = entry.nextSilbling) {
      parseSwitch(entry);
    }
  }
}

function parseSwitch(entry) {
  var atts = entry.attributes;
  for (var i = 0; i < atts.length; i++) {
    var attr = atts[i];
    var name = attr.nodeName;
    var value = attr.nodeValue;
    var el = document.getElementById(name);
    el.innerHTML = value;
  }
}

function writeValues() {
  var value = document.getElementById('openPositionMs').value;

  xhttp.open('POST', URI, true);
  xhttp.setRequestHeader('Content-type', 'application/xml');
  xhttp.send('<mume>' + posSnippet('openPositionMs') + posSnippet('closePositionMs') + '</mume>');
}

function posSnippet(id) {
  var value = document.getElementById(id).value;
  return '<' + id + ' value="' + value + '"/>';
}

