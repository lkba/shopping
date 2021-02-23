var pageObj1={
        showCount:0,//记录显示列表的数量
        showNum:0,//记录点击按钮显示
        NUM:0,//测试分页总的显示数量
        clickNum:0,//记录点击的次数
        clickPage:1,//页面的点击默认为第一页
        DATA:null,//保存传过来的数据
        ID:null,//包存分页层的id
    init:function(options){
        this.ID=options.id;
        this.showCount=options.showcount;
        this.showNum=options.shownum;
        this.DATA=options.data;
        this.NUM=this.DATA.length%this.showCount==0?this.DATA.length/this.showCount:parseInt(this.DATA.length/this.showCount)+1;
        this.viewPage();
        this.addPageNum();
        this.clickSpan();
    },
    //设置分页按钮及显示按钮的个数
    addPageNum:function(){
        var html='<div class="lf mid" id="mid1">';
        for(var i=0;i<this.NUM;i++){
            if(i==0){
                html+="<span i='"+(i+1)+"' class='hover'></span>";
            }else{
                html+="<span i='"+(i+1)+"'></span>";
            }
        }
        html+='</div>';
        $("#"+this.ID).html(html);
        //var width=parseInt(this.showNum)*(parseInt($("#mid>span").css("width"))+10);//10位span的margin值
        $(".mid").css("width",'100%');
    },
    //点击分页数字
    clickSpan:function(){
        var me=this;
        $("#mid1>span").click(function(){
            $(this).attr("class","hover").siblings().removeClass();
            me.clickPage=$(this).attr("i");
            me. viewPage();
        })
    },
    //页面显示功能
    viewPage:function(){
            var cHtml="";
            if(this.clickPage==this.NUM){
                var result=this.DATA.slice((this.clickPage-1)* this.showCount,this.DATA.length);
                options1.callback(result);
            }
            else{
                var result=this.DATA.slice((this.clickPage-1)*this.showCount,(this.clickPage-1)*this.showCount+this                            .showCount);
                options1.callback(result);
            }
    }
};
var pageObj2={
        showCount:0,//记录显示列表的数量
        showNum:0,//记录点击按钮显示
        NUM:0,//测试分页总的显示数量
        clickNum:0,//记录点击的次数
        clickPage:1,//页面的点击默认为第一页
        DATA:null,//保存传过来的数据
        ID:null,//包存分页层的id
    init:function(options){
        this.ID=options.id;
        this.showCount=options.showcount;
        this.showNum=options.shownum;
        this.DATA=options.data;
        this.NUM=this.DATA.length%this.showCount==0?this.DATA.length/this.showCount:parseInt(this.DATA.length/this.showCount)+1;
        this.viewPage();
        this.addPageNum();
        this.clickSpan();
    },
    //设置分页按钮及显示按钮的个数
    addPageNum:function(){
        var html='<div class="lf mid" id="mid2">';
        for(var i=0;i<this.NUM;i++){
            if(i==0){
                html+="<span i='"+(i+1)+"' class='hover'></span>";
            }else{
                html+="<span i='"+(i+1)+"'></span>";
            }
        }
        html+='</div>';
        $("#"+this.ID).html(html);
        //var width=parseInt(this.showNum)*(parseInt($("#mid>span").css("width"))+10);//10位span的margin值
        $(".mid").css("width",'100%');
    },
    //点击分页数字
    clickSpan:function(){
        var me=this;
        $("#mid2>span").click(function(){
            $(this).attr("class","hover").siblings().removeClass();
            me.clickPage=$(this).attr("i");
            me. viewPage();
        })
    },
    //页面显示功能
    viewPage:function(){
            var cHtml="";
            if(this.clickPage==this.NUM){
                var result=this.DATA.slice((this.clickPage-1)* this.showCount,this.DATA.length);
                options2.callback(result);
            }
            else{
                var result=this.DATA.slice((this.clickPage-1)*this.showCount,(this.clickPage-1)*this.showCount+this                            .showCount);
                options2.callback(result);
            }
    }
};

