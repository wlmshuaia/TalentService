// JavaScript Document


a=function(msg)
{
	var daojishi=document.getElementById("daojishi");
	var time=parseInt(msg)/1000;
	
	var second=parseInt(time%60);
	var mintue=parseInt((time/60)%60);
	var hour=parseInt((time/60/60)%24);
	var day=parseInt((time/60/60)/24);
	
	function aa()
	{
		daojishi.innerHTML=day+"天"+hour+"小时"+mintue+"分"+second+"秒";
		second--;
		if(second==0)
		{second=60;
		mintue--;}
		if(mintue==0)
		{mintue=60;
		hour--;}
		if(hour==0)
		{hour=24;
		day--;}
		if(day<0)
		{clearInterval(tim);}
		
	}
	var tim=setInterval(aa,1000);
	
}