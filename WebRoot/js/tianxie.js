// JavaScript Document
function t()
{
	var juzhudi=document.getElementById("juzhudi");
	var diquxuanze=document.getElementById("diquxuanze");
	var dqxz=diquxuanze.getElementsByTagName("select");
	
	
	dqxz[2].onchange=function()
	{
		juzhudi.value=dqxz[0].value+" --- "+dqxz[1].value+" --- "+dqxz[2].value;
	}
	
	
	
}