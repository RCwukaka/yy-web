var ddmenuitem = 0;
function mopen(id)
{	
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
	ddmenuitem = document.getElementById(id);
	ddmenuitem.style.visibility = 'visible';
}
function mclose()
{
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}
