    window.onload= function(){
        notesummer();
        document.getElementsByClassName("note-editable")[0].addEventListener("input", function(){
            if(this.innerText.trim().length>0){
                reviewCheckObj.content= true;
            }
            else{
                reviewCheckObj.content= false;
            }
        })
    }
    let imagesNum = 0;
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
        document.getElementsByName("title")[0].addEventListener("input", function(){
            if(this.value.trim().length>0){
                reviewCheckObj.title= true;
            }
            else{
                reviewCheckObj.title= false;
            }
        })
        
        $("input[name='point']").on("change", function(){
            if($("input[name='point']").is(":checked")){
                reviewCheckObj.point= true;
        }
        else{
            reviewCheckObj.point= false;
        }
    })


    /* 썸머노트 */

     //썸머노트 실행 함수
    function notesummer(){
        //썸머노트 실행
        $('#summernote').summernote({
        lang:"ko-KR",
        placeholder: '내용을 입력해주세요',
        tabsize: 2,
        width : 1200,
        height: 600,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ],
        callbacks : { 
            //onImageUpload = 이미지 업로드시 작동하는 콜백함수
            onImageUpload : function(files, editor, welEditable) {
        // 파일 업로드(다중업로드를 위해 반복문 사용)
                if(imagesNum<=1){
                    for (var i = files.length - 1; i >= 0; i--) {
                        console.log("이미지 업로드");
                            uploadSummernoteImageFile(files[i],
                            this);
                            imagesNum++;
                    }
                }
                else{
                    alert("리뷰 이미지업로드는 2장으로 제한됩니다.");
                    return;
                }
            }
        }//end callbacks 
        });
        // 이미지 업로드시 ajax로 파일 업로드를 하고 성공 후 파일 경로를 return받음
        function uploadSummernoteImageFile(file, editor) {
        data = new FormData();
        data.append("file", file);
        console.log(data);
        $.ajax({
            url : contextPath+"/admin/board/summernoteImage",
            data : data,
            type : "POST",
            dataType : 'JSON',
            contentType : false,
            processData : false,
            success : function(data) {
                //항상 업로드된 파일의 url이 있어야 한다.
                console.log(data);
                console.log(data.url);
                $(editor).summernote('insertImage', contextPath+data.url);
            }
        });
        } 
    }