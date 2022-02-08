
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
        contentbox.innerHTML="";
        const canvas= document.createElement("canvas")
        canvas.setAttribute("id", "chartdiv");
        canvas.setAttribute("width" , "400");
        canvas.setAttribute("height" , "300");
        const canvas2= document.createElement("canvas")
        canvas2.setAttribute("id", "chartdiv2");
        canvas2.setAttribute("width" , "400");
        canvas2.setAttribute("height" , "300");
        contentbox.append(canvas,canvas2);

        let chartdiv = document.getElementById("chartdiv");
        const convar = chartdiv.getContext("2d");
        let lineChart = new Chart(chartdiv, {
            //toDo
            type: 'bar',
            data : {
                labels: ['1월', '2월', '3월','4월'],
                datasets: [{
                    label: '빵1',
                    data :[ 1, 2,3,4],
                    backgroundColor: "lime"
                },{
                    label: '빵2',
                    data: [6 ,8,9,10],
                    backgroundColor:"yellow"
                },{
                    label: '빵3',
                    data: [10 ,11,12,13],
                    backgroundColor:"blue"
                }]
            },
            options:{
                responsive: false,
            }
        });
        let chartdiv2 = document.getElementById("chartdiv2");
        const convar2 = chartdiv2.getContext("2d") ;
        let lineChart2 = new Chart(chartdiv2, {
            //toDo
            type: 'bar',
            data : {
                labels: ['1월', '2월', '3월','4월'],
                datasets: [{
                    label: '빵1',
                    data :[ 1, 2,3,4],
                    backgroundColor: "lime"
                },{
                    label: '빵2',
                    data: [6 ,8,9,10],
                    backgroundColor:"yellow"
                },{
                    label: '빵3',
                    data: [10 ,11,12,13],
                    backgroundColor:"blue"
                }]
            },
            options:{
                responsive: false,
            }
        });
}