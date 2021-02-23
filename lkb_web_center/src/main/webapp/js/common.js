function show_l(num, change, ide) {
    var menu = document.getElementById(num);
    var menu_span = menu.getElementsByTagName("span")[0];
    var change = document.getElementById(change);
    var cha = change.getElementsByTagName("span")[0];
    if (cha.innerHTML == "+") {
        cha.innerHTML = "-";
    } else {
        cha.innerHTML = "+";
    }
    if (menu.style.display == 'none') {
        menu.style.display = '';
    } else {
        menu.style.display = 'none';
    }
}

function show(title, url, w, h) {
    w = w;
    layer.open({
        type: 2,
        title: title,
        shadeClose: true,
        shade: 0.4,
        area: [w, h],
        content: url //iframe的url
    });
}

function edit(title, url, w, h) {
    layer.open({
        type: 2,
        title: title,
        shadeClose: true,
        shade: 0.4,
        area: [w, h],
        content: url //iframe的url
    });
}