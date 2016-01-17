// Menu G5.5.1 (frame)
// Last Modified: Jul. 03, 2004
// Web Site: yxScripts.com
// Email: m_yangxin@hotmail.com

// Copyright 2003, 2004  Xin Yang   All Rights Reserved.

var _assumeFrameset=1;
var _framesetURL="/ibiraweb/jsp/";
if(typeof(assumeFrameset)=="undefined"){
    assumeFrameset=_assumeFrameset
        };
        
if(typeof(framesetURL)=="undefined"){
    framesetURL=_framesetURL
        };
        
var yx_if=yx_ie=yx_bt=yx_bs=yx_ib=yx_ig=yx_br=yx_bu=yx_ia=yx_bq=null;
var yx_fo=yx_fp=null;
var yx_ow=yx_oh=0;
var yx_FS=yx_cq();
var setSubFrame=yx_FS.setSubFrame,setSubID=yx_FS.setSubID,setSubFrameName=yx_FS.setSubFrameName;
var addMenu=yx_FS.addMenu,addSubMenu=yx_FS.addSubMenu,addLink=yx_FS.addLink,addCommand=yx_FS.addCommand,addInfo=yx_FS.addInfo,addSeparator=yx_FS.addSeparator,endMenu=yx_FS.endMenu,addInstance=yx_FS.addInstance;
var addStylePad=yx_FS.addStylePad,addStyleItem=yx_FS.addStyleItem,addStyleFont=yx_FS.addStyleFont,addStyleTag=yx_FS.addStyleTag,addStyleIcon=yx_FS.addStyleIcon,addStyleSeparator=yx_FS.addStyleSeparator,addStyleMenu=yx_FS.addStyleMenu,addStyleGroup=yx_FS.addStyleGroup;
var addItemEvent=yx_FS.addItemEvent,addMenuEvent=yx_FS.addMenuEvent,addWindowEvent=yx_FS.addWindowEvent;
var showMenu=yx_FS.showMenu,showMenuX=yx_FS.showMenuX,hideMenu=yx_FS.hideMenu,hideMenuX=yx_FS.hideMenuX,openMenu=yx_FS.openMenu,openMenuX=yx_FS.openMenuX,closeMenu=yx_FS.closeMenu,closeMenuX=yx_FS.closeMenuX,closeMenuNow=yx_FS.closeMenuNow,moveMenuTo=yx_FS.moveMenuTo,moveMenuBy=yx_FS.moveMenuBy,moveMenuBack=yx_FS.moveMenuBack,setCoordinates=yx_FS.setCoordinates,getMenuDim=yx_FS.getMenuDim,slideMenuBack=yx_FS.slideMenuBack,showPagePath=yx_FS.showPagePath,resetPagePath=yx_FS.resetPagePath,updateItemDisplay=yx_FS.updateItemDisplay,updateItemLink=yx_FS.updateItemLink,updateItemCode=yx_FS.updateItemCode;
function initMenu(cy,dp,f){
    yx_FS.initMenu(cy,dp,f||self)
    };
    
function initSub(cy){
    yx_FS.initSub(cy,self)
    };
    
function getLeft(id){
    var l=yx_FS.yx_ci(self,id);
    return l==null?0:(yx_FS.yx_cx(l))
    };
    
function getTop(id){
    var l=yx_FS.yx_ci(self,id);
    return l==null?0:(yx_FS.yx_dm(l))
    };
    
function clickMenu(cy){
    yx_FS.clickMenu(cy,self)
    };
    
function clickMenuX(cy){
    yx_FS.clickMenuX(cy,self)
    };
    
function switchMenu(cy){
    yx_FS.switchMenu(cy,self)
    };
    
function setHolder(n,id){
    yx_FS.setHolder(n,id,self)
    };
    
function yx_cq(){
    var fs=parent;
    while(fs!=top&&typeof(fs.yx_menuSafe)=="undefined"){
        fs=fs.parent
        };
        
    if(fs==self||typeof(fs.yx_menuSafe)=="undefined"){
        if(assumeFrameset==1){
            fs=top
            }else{
            top.location.replace(framesetURL)
            }
        };
    
return fs
};

function yx_hz(){
    return true
    };
    
function yx_aw(e){
    if(yx_FS.yx_menuSafe){
        if(yx_FS.yx_isGecko){
            if(e.gg=="click"){
                var db=yx_FS.yx_ef;
                yx_FS.yx_aw();
                if(!db){
                    yx_bq(e);
                    yx_ia(e)
                    }
                }else if(e.gg=="mousedown"&&!yx_FS.yx_ef){
            yx_br(e);
            yx_ib(e)
            }else if(e.gg=="mouseup"&&!yx_FS.yx_ef){
            yx_bu(e);
            yx_ig(e)
            }
        }else{
    yx_FS.yx_aw(1);
    yx_bq()
    }
}
};

function yx_bk(){
    if(yx_FS.yx_menuSafe){
        if(yx_FS!=self){
            yx_FS.yx_bk(self)
            }
        };
    
yx_fp()
};

function yx_gd(){
    if(yx_FS.yx_menuSafe){
        var nw=yx_FS.yx_do(self),nh=yx_FS.yx_dn(self);
        if(yx_ow!=nw||yx_oh!=nh){
            yx_ow=nw;
            yx_oh=nh;
            yx_fo();
            yx_FS.yx_gd(self)
            }
        }
};

if(yx_FS.yx_isGecko){
    yx_ib=window.onmousedown?window.onmousedown:yx_hz;
    yx_ig=window.onmouseup?window.onmouseup:yx_hz;
    yx_ia=window.onclick?window.onclick:yx_hz;
    yx_br=document.onmousedown?document.onmousedown:yx_hz;
    yx_bu=document.onmouseup?document.onmouseup:yx_hz;
    yx_bq=document.onclick?document.onclick:yx_hz;
    document.onmousedown=yx_aw;
    document.onmouseup=yx_aw;
    document.onclick=yx_aw;
    window.onmousedown=yx_hz;
    window.onmouseup=yx_hz;
    window.onclick=yx_hz
        }else{
    yx_bq=document.onclick?document.onclick:yx_hz;
    document.onclick=yx_aw
        };
        
yx_fo=window.onresize?window.onresize:yx_hz;
window.onresize=yx_gd;
yx_fp=window.onunload?window.onunload:yx_hz;
window.onunload=yx_bk;