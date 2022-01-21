 const reviewCheckObj = {
    "title" : false,
    "point" : false,
    "content" : false
    }
    function validate(){
        for( key  in reviewCheckObj ){
            if( !reviewCheckObj[key] ){
                let message;
                switch(key){
                case "title" : message = "제목이 입력해주세요"; break;
                case "point" : message = "평점을 입력해주세요"; break;
                case "content" : message = "내용을 입력해주세요"; break;
                }
            alert(message);
            return false;
            }
    }}
    document.getElementsByName("review-title")[0].addEventListener("input", function(){
        if(this.value.trim().length>0){
            reviewCheckObj.title= true;
        }
        else{
            reviewCheckObj.title= false;
        }
    })
    document.getElementsByName("reviewcontent")[0].addEventListener("input", function(){
        if(this.value.trim().length>0){
            reviewCheckObj.content= true;
        }
        else{
            reviewCheckObj.content= false;
        }
    })
    $("input[name='review-point']").on("change", function(){
        if($("input[name='review-point']").is(":checked")){
            reviewCheckObj.point= true;
        }
        else{
            reviewCheckObj.point= false;
        }
    })