
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
            contentbox.innerHTML="";
            let names = [];
            let ranks = [];
            let counts = [];
            const newbox =document.createElement("div")
            newbox.setAttribute("id", "newboxs");
            newbox.setAttribute("width" , "100%");
            newbox.setAttribute("height" , "100%");
            contentbox.append(newbox);
            const divbox = document.createElement("div")
            divbox.setAttribute("id", "rank");
            divbox.setAttribute("width" , "500px");
            divbox.setAttribute("height" , "500px");

            for(let i = 0 ; i< result.length ; i++){
                names[i] = result[i].productName;
                counts[i] = result[i].sales;
                ranks[i] = result[i].rank;
                const div = document.createElement("div")
                div.className="disrank";
                div.innerHTML = "<span class='salerank'> "+(result.length-i)+"위</span> " 
                + names[i] +" ("+counts[i] +" 개 )";
                divbox.prepend(div);
            }
            console.log(names);
            const div = document.createElement("div")
            div.className = "chartTitle"
            div.innerText ="<주간 스토어 판매 순위!>"
            divbox.prepend(div);
            const canvas= document.createElement("canvas")
            canvas.setAttribute("id", "chartdiv");
            canvas.setAttribute("width" , "700");
            canvas.setAttribute("height" , "500");

            newbox.append(divbox,canvas);
            


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
                        backgroundColor: "purple"
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