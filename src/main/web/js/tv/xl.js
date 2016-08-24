/**
 * Created by Administrator on 2016-08-12.
 */
var id = 0;
function DivShow()
{
    var iDiv = document.getElementById("aaa");
    if(iDiv)
    {
        if(iDiv.style.display=="block")
        {
            iDiv.style.display="none";
        }
        else
        {
            iDiv.style.display="block";
        }
    }
    id = (id + 1) % 2;
    document.getElementById("bbb").src = './img/' + id + '.png'; //动态设定src
    console.log(id);
}




