$(function () {
    let navflag = false;
    $('.nav-tab').click(function () {
        $(this).siblings().each(function () {
            $(this).removeClass('a_active');
            // $(this).removeClass('a_active');
            $(this).find('.nav-box').css('height', '0')
            //关闭右侧箭头
            if ($(this).attr('class').indexOf('nav-ul') != -1) {
                $(this).find('.bx-chevron-right').css('transform', 'rotateZ(0deg)')
                $(this).find('.bx-chevron-right').css('transition', 'all .5s')
                $(this).removeClass('nav-show')
                // $(this).find('div').removeClass('nav-box')
            }
        })
        //当前选中
        $(this).addClass('a_active')
        $(this).find('.li-a').addClass('active')
        // 打开右侧箭头
        $(this).find('.bx-chevron-right').css('transform', 'rotateZ(90deg)')
        $(this).find('.bx-chevron-right').css('transition', 'all .5s')
        $(this).addClass('nav-show')
        // $(this).find('div').addClass('nav-box')
    })
    /* 二级菜单a点击事件 */
    $(".li-a-a").click(function () {
        $(".li-a-a").each(function () {
            $(this).removeClass('active-li-a');
        })
        $(this).addClass('active-li-a');
    })

});