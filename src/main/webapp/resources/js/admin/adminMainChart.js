
document.getElementById("showChart").addEventListener("click", e=>{
    if(!e.target.matches('#showChart')) 
    {
        console.log("안맞음");
        return;
    }
    e.preventDefault();
    //이동 방지
    firstdone=true;
    const path = e.target.getAttribute('href');
    // pushState는 주소창의 url을 변경하지만 HTTP 요청을 서버로 전송하지는 않는다.
    window.history.pushState({}, null, path);
    render(path);
})

function drawing(){

    $.ajax({
        url : contextPath+"/admin/board/getChartData",
        data : {},
        type : "POST",
        dataType : 'JSON',
        success : function(data) {
            const result = JSON.parse(data.storeSales);
            console.log(result);
            let names = [];
            let ranks = [];
            let counts = [];
            let dates = [];
            for(let i = 0 ; i< result.length ; i++){
                names[i] = result[i].productName;
                counts[i] = result[i].sales;
                ranks[i] = result[i].rank;
            }
            console.log(names);
            contentbox.innerHTML="";

            const canvas= document.createElement("canvas")
            canvas.setAttribute("id", "chartdiv");
            canvas.setAttribute("width" , "700");
            canvas.setAttribute("height" , "500");
    
            contentbox.append(canvas);
            


            let chartdiv = document.getElementById("chartdiv");
            const convar = chartdiv.getContext("2d");
            let lineChart = new Chart(chartdiv, {
                //toDo
                type: 'bar',
                data : {
                    labels: ['판매량 차트'],
                    datasets: [{
                        label: names[0],
                        data :[counts[0]],
                        backgroundColor: "lime"
                    },
                    {
                        label: names[1],
                        data :[counts[1]],
                        backgroundColor: "blue"
                    },
                    {
                        label: names[2],
                        data :[counts[2]],
                        backgroundColor: "yellow"
                    },
                    {
                        label: names[3],
                        data :[counts[3]],
                        backgroundColor: "red"
                    },
                    {
                        label: names[4],
                        data :[counts[4]],
                        backgroundColor: "orange"
                    }
                ]
                },
                options:{
                    responsive: false,
                }
            });

        }
    })
}