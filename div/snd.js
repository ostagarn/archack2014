/*
 * This is a JavaScript Scratchpad.
 *
 * Enter some JavaScript, then Right Click or choose from the Execute Menu:
 * 1. Run to evaluate the selected text (Ctrl+R),
 * 2. Inspect to bring up an Object Inspector on the result (Ctrl+I), or,
 * 3. Display to insert the result in a comment after the selection. (Ctrl+L)
 */

var jq = document.createElement('script');
jq.src = "//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js";
document.getElementsByTagName('head')[0].appendChild(jq);
// ... give time for script to load, then type.
jQuery.noConflict();


//------------------skapa diven i kringla med frågan om det är samma persion -------------
var e = $('<div id="snddiv"  class="relatedobjects"></div>');
$("#sidebar").append(e);
var bottom = $('<div class="bottomBorder"></div>');
$("#sidebar").append(bottom);


var divKoden = '<h2>Svensk Nationell Datatjänst</h2>';
divKoden += '<p><a hrep="#">Linköping 460</a></p>'

$("#snddiv").html(divKoden);

//-------------------------------------------------------------------------------------------
alert($("#related").html());




//------------------skapa diven i kringla med länkarna till librisböcker -------------
var e = $('<div id="librisdiv" style="display:block; float:left;px;border:0px dashed #CCCCCC;"></div>');
$("#article-sidebar").append(e);



var divKoden = '<h2>LITTERATUR FRÅN LIBRIS!</h2>';

divKoden += '<ul style="list-style:none;" ><li>Asplund, Gunnar, 1885-1940 <span class="beskrivning">(författare)</span>';
divKoden += '</li><li><a href="showrecord?q=gunnar+asplund&amp;r=;pers:(Asplund Gunnar 1885 1940)&amp;n=1&amp;id=710966&amp;g=&amp;f=simp&amp;s=r&amp;t=v&amp;m=10&amp;d=libris">Texter och bilder ur Riksutställningars utställning om Erik Gunnar Asplund.</a>';
divKoden += '</li><li>1987 &nbsp; Bok<span></span><span class="diss"></span><span class="diss"></span></li></ul>';

divKoden += '<ul style="list-style:none;" ><li>Asplund, Gunnar, 1885-1940 <span class="beskrivning">(författare)</span>';
divKoden += '</li><li><a href="showrecord?q=gunnar+asplund&amp;r=;pers:(Asplund Gunnar 1885 1940)&amp;n=9&amp;id=10967330&amp;g=&amp;f=simp&amp;s=r&amp;t=v&amp;m=10&amp;d=libris">Erik Gunnar Asplund : architecte et designer suédois</a>';
divKoden += '</li><li>1989 &nbsp; Bok<span></span><span class="diss"></span><span class="diss"></span></li></ul>';


divKoden += '<ul style="list-style:none;" ><li><a href="#">Till alla poster i Libris</a></li></ul>';

$("#librisdiv").html(divKoden);


//-------------------------------------------------------------------------------------------


jQuery.ajax({
    url: 'http://127.0.0.1:9000/findLibrisPerson/name/Gunnar Asplund',
    type: 'GET',
    dataType: 'json',
    success: function(data, textStatus, xhr) {
        alert(data);
    },
    error: function(xhr, textStatus, errorThrown) {
    console.log(xhr);
       
    }
});

jQuery.getJSON( "http://127.0.0.1:9000/findLibrisPerson/name/Gunnar Asplund", function( data ) {
    $.each( data, function( key, val ) {
        console.log('jajaaa');
    });
});

