index={
    url:"/filedir/",
    init:function(){
        if(window.location.protocol=="file:"){
            this.url = "http://192.168.0.100:8080/filedir/"
        }
    },

    getUsesrs:function(){
        $.ajax({
            url:this.url,
            // type:"get",
            async:false,
            dataType:"json",
            success :function(data){
                var userList = {users:data}
                Common.fillTemplate('listTemplate',userList,$("#list"));
            }
        });
    },
    getUserDir:function (username) {
        $.ajax({
            url:this.url+username,
            dataType:"json",
            //data:{scope:"active"},
            error:function(){},
            success:function(data){
                var dirList = [];
                for(var i=1;i<=data.length;i++){
                    var uriString = data[i-1];
                    var splitPoint = uriString.indexOf(":")
                    var uri = {
                        index : i,
                        key:uriString.substring(0,splitPoint),
                        value:uriString.substring(splitPoint+1)
                    }
                    dirList.push(uri);
                }
                Common.fillTemplate('tableTemplate',{urls:dirList},$("#tbody"));


            }
        });
    },
    open:function(uri){
        alert(uri);
        window.open(uri);
    }
}
index.init();
index.getUsesrs();