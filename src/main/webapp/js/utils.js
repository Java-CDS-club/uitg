$(document).ready(function () {

//    resizeWindow();
//    $(window).resize(resizeWindow);

});


var resizeWindow = function() {
    var content = $('#content');

    var height = $(window).height();
    var headerHeight = $('#header').height();
    var contentHeight = height - headerHeight;
    content.height(contentHeight);

    var width = $(window).width();
    var menuWidth = $('#menu').width();
    var contentWidth = width - menuWidth;
    alert("height: " + height + ", headerHeight: " + headerHeight + ", contentHeight: " + contentHeight);
    content.width(contentWidth - 110);
};
