// Menu G5.6.1 (frameset/Safari)
// Last Modified: Jun. 15, 2005
// Web Site: yxScripts.com
// Email: m_yangxin@hotmail.com

// Copyright 2003, 2004  Xin Yang   All Rights Reserved.

function yx_do(f){
    return f.innerWidth
    };
    
function yx_dn(f){
    return f.innerHeight
    };
    
function yx_de(f){
    return f.pageXOffset
    };
    
function yx_df(f){
    return f.pageYOffset
    };
    
function yx_cx(l){
    return l.offsetLeft+(l.offsetParent?yx_cx(l.offsetParent):0)
    };
    
function yx_dm(l){
    return l.offsetTop+(l.offsetParent?yx_dm(l.offsetParent):0)
    };
    
function yx_fh(f,x,y,h,gh,cu){
    var l=yx_fe(f,x,y,gh,cu),ac=h||f.document.body;
    return ac.appendChild(l)
    };
    
function yx_go(f){
    return f.event?f.event.shiftKey:false
    };
    
function yx_gv(f){
    if(f.event){
        f.event.cancelBubble=true
        }
    };

function yx_en(){
    var dg=this.dg,cl=dg.cl,au=this.au,gg=au.gg,x=this.item;
    if(gg!=yx_S&&gg!=yx_I){
        x.onmouseover=yx_ft;
        x.onmouseout=yx_fq;
        x.onmousedown=yx_bw;
        x.onclick=yx_ax;
        if(this.au.du!=""&&showToolTip==1){
            x.title=this.au.du
            };
            
        x.dm=yx_eq;
        x.item=this
        }else{
        x.onmouseover=yx_fu;
        x.onmouseout=yx_fr;
        x.onclick=yx_av;
        x.cl=cl
        };
        
    x.sticky=cl.sticky;
    this.av=this.item;
    x.dc=dg.dg==cl?1:0;
    x.ap=(x.dc||cl.da)?cl.gd:cl.fp;
    var ee=yx_ch(au.ci);
    if(ee!=null){
        this.as=ee.as;
        this.at=ee.at;
        this.dp=ee.dp
        };
        
    if(gg==yx_M){
        this.menu=new yx_er(cl,this,au)
        }
    };

function yx_eo(){
    var dg=this.dg,au=this.au,dp=au.eg,gg=au.gg,si=this.fm=yx_cw(this),f=yx_cs(dg);
    if(si.fb.actual&&gg!=yx_S){
        dg.actual=true
        };
        
    this.item=yx_fh(f,0,0,dg.holder,"inherit",yx_ej);
    if(gg==yx_M||gg==yx_L||gg==yx_C){
        this.item.className=si.fb.be[dp];
        if(si.fa!=null){
            if(si.fa.bc!=""){
                this.cs=yx_ff(f,"SPAN");
                this.cs.className=si.fa.be[dp];
                if(si.fa.text!=""){
                    this.cs.innerHTML=si.fa.text
                    };
                    
                this.item.appendChild(this.cs)
                };
                
            if(si.fa.bd!=""){
                this.ct=yx_ff(f,"SPAN");
                this.ct.className=si.fa.bf[dp];
                if(si.fa.text2!=""){
                    this.ct.innerHTML=si.fa.text2
                    };
                    
                this.item.appendChild(this.ct)
                }
            };
        
    if(gg==yx_M&&si.fe!=null&&si.fe.bc!=""){
        this.fu=yx_ff(f,"SPAN");
        this.fu.className=si.fe.be[dp];
        if(si.fe.text!=""){
            this.fu.innerHTML=si.fe.text
            };
            
        this.item.appendChild(this.fu)
        };
        
    this.bl=yx_ff(f,si.fb.actual?"NOBR":"SPAN");
    this.bl.className=si.ez.be[dp];
    this.bl.innerHTML=au.bl;
    this.item.appendChild(this.bl)
    }else if(gg==yx_I){
    this.item.className=si.fb.bc;
    this.bl=yx_ff(f,si.fb.actual?"NOBR":"SPAN");
    this.bl.className=si.ez.bc;
    this.bl.innerHTML=au.bl;
    this.item.appendChild(this.bl)
    }else if(gg==yx_S){
    var fh=yx_ff(f,"DIV");
    fh.className=si.fd.bi;
    fh.appendChild(yx_fg(f,yx_fx.src,1,1,"top"));
    this.item.appendChild(fh);
    if(si.fd.ax!=""){
        var fg=yx_ff(f,"DIV");
        fg.className=si.fd.ax;
        fg.appendChild(yx_fg(f,yx_fx.src,1,1,"top"));
        this.item.appendChild(fg);
        if(dg.bar){
            fh.style.cssFloat="left";
            fg.style.cssFloat="left"
            }
        }
};

this.aw=0;
this.ah=0;
if(gg!=yx_S){
    this.aw=Math.max(minimumWidth,yx_ei(this));
    this.ah=Math.max(Math.max(Math.max(this.bl.offsetHeight,this.fu!=null?(this.fu.offsetHeight):0),this.cs!=null?(this.cs.offsetHeight):0),this.ct!=null?(this.ct.offsetHeight):0)
    }
};

function yx_ep(){
    var f=yx_cs(this),cl=this.cl;
    this.style=yx_cz(this);
    var fc=this.style.fc;
    this.bar=(this.dg==cl&&cl.bar||this.dg!=cl&&fc.bar)?true:false;
    this.holder=yx_fh(f,0,0,null,"hidden",cl.z);
    this.holder.cz=cl.cz;
    if(fc.ck!=""){
        this.holder.className=fc.ck
        };
        
    this.pad=yx_fh(f,0,0,this.holder,"inherit",yx_fv);
    var x=this.pad;
    if(fc.bc!=""){
        x.className=fc.bc
        };
        
    x.onmouseover=yx_fu;
    x.onmouseout=yx_fr;
    x.onclick=yx_ay;
    x.sticky=cl.sticky;
    x.menu=this;
    x.cl=cl;
    x.dc=this.dg==cl?1:0;
    x.ap=(x.dc||cl.da)?cl.gd:cl.fp;
    var df=this.df;
    for(var i=0;i<this.dd;i++){
        df[i]=new yx_eg(this,this.au.df[i]);
        df[i].dk()
        };
        
    if(this.actual){
        for(var i=0;i<this.dd;i++){
            if(df[i].au.gg!=yx_S){
                df[i].item.style.width=df[i].aw+"px"
                }
            }
        };
    
var mw=new Array(),mh=new Array();
var cc=0,rc=0,tw=0,th=0,col=0,row=0;
if(this.bar){
    col=fc.col>0?fc.col:fc.row>0?Math.ceil(this.dd/fc.row):this.dd;
    row=Math.ceil(this.dd/col);
    for(var i=0;i<row;i++){
        mw[i]=0;
        mh[i]=0
        };
        
    for(var i=0;i<this.dd;i++){
        if(df[i].au.gg!=yx_S&&mh[rc]<df[i].item.offsetHeight){
            mh[rc]=df[i].item.offsetHeight
            };
            
        if(++cc==col){
            cc=0;
            rc++
        }
    };
    
cc=rc=0;
for(var i=0;i<this.dd;i++){
    if(df[i].au.gg!=yx_S){
        if(df[i].item.offsetHeight<mh[rc]){
            df[i].item.style.height=(df[i].ah+mh[rc]-df[i].item.offsetHeight)+"px"
            };
            
        mw[rc]+=df[i].item.offsetWidth
        };
        
    if(++cc==col){
        cc=0;
        rc++
    }
};

cc=rc=0;
for(var i=0;i<this.dd;i++){
    var cw=0;
    if(df[i].au.gg==yx_S){
        for(var j=0;j<df[i].item.childNodes.length;j++){
            var cn=df[i].item.childNodes[j];
            cn.style.height=mh[rc]+"px";
            cw+=cn.offsetWidth
            };
            
        df[i].item.style.width=cw+"px";
        mw[rc]+=cw
        };
        
    if(++cc==col){
        cc=0;
        rc++
    }
};

for(var i=0;i<row;i++){
    th+=mh[i];
    tw=Math.max(tw,mw[i])
    }
}else{
    row=fc.row>0?fc.row:fc.col>0?Math.ceil(this.dd/fc.col):this.dd;
    col=Math.ceil(this.dd/row);
    for(var i=0;i<col;i++){
        mw[i]=0;
        mh[i]=0
        };
        
    for(var i=0;i<this.dd;i++){
        if(df[i].au.gg!=yx_S&&mw[cc]<df[i].item.offsetWidth){
            mw[cc]=df[i].item.offsetWidth
            };
            
        if(++rc==row){
            rc=0;
            cc++
        }
    };
    
cc=rc=0;
for(var i=0;i<this.dd;i++){
    if(df[i].au.gg!=yx_S){
        if(df[i].item.offsetWidth<mw[cc]){
            df[i].item.style.width=(df[i].aw+mw[cc]-df[i].item.offsetWidth)+"px"
            };
            
        mh[cc]+=df[i].item.offsetHeight
        };
        
    if(++rc==row){
        rc=0;
        cc++
    }
};

cc=rc=0;
for(var i=0;i<this.dd;i++){
    if(df[i].au.gg==yx_S){
        df[i].item.style.width=mw[cc]+"px";
        mh[cc]+=df[i].item.offsetHeight
        };
        
    if(++rc==row){
        rc=0;
        cc++
    }
};

for(var i=0;i<col;i++){
    th=Math.max(th,mh[i]);
    tw+=mw[i]
    }
};

var aw=tw+(col-1)*fc.cq,ah=th+(row-1)*fc.cr;
x.style.width=aw+"px";
x.style.height=ah+"px";
this.width=x.offsetWidth;
this.height=x.offsetHeight;
this.sW=(this.width-aw)/2;
this.sH=(this.height-ah)/2;
if(fc.fz>0||fc.fy>0){
    this.fw=yx_fh(f,0,0,this.holder,"inherit",yx_hs);
    this.fw.style.width=this.width+"px";
    this.fw.style.height=this.height+"px";
    this.fw.innerHTML=yx_dk(fc,this.width,this.height);
    this.fw.onmouseover=yx_fu;
    this.fw.onmouseout=yx_fr;
    this.fw.onclick=yx_ay;
    this.fw.cl=x.cl;
    this.fw.dc=x.dc;
    this.fw.ap=x.ap
    };
    
cc=rc=0;
var dx=this.sW,dy=this.sH;
for(var i=0;i<this.dd;i++){
    df[i].x=dx;
    df[i].y=dy;
    df[i].ox=dx;
    df[i].oy=dy;
    df[i].width=df[i].item.offsetWidth;
    df[i].height=df[i].item.offsetHeight;
    df[i].ow=df[i].width;
    df[i].oh=df[i].height;
    yx_ey(df[i].item,dx,dy);
    if(this.bar){
        dx+=df[i].width+fc.cq;
        if(++cc==col){
            dx=this.sW;
            dy+=mh[rc]+fc.cr;
            cc=0;
            rc++
        }
    }else{
    dy+=df[i].height+fc.cr;
    if(++rc==row){
        dy=this.sH;
        dx+=mw[cc]+fc.cq;
        rc=0;
        cc++
    }
};

df[i].dj()
};

var ee=yx_cj(this.au.name);
if(ee!=null){
    this.as=ee.as;
    this.at=ee.at
    };
    
this.ew=true;
this.cb=false;
if(this.go){
    this.fj()
    }
};

function yx_gj(item,cp,fr,dz,ea,bv,dp,gp,gt){
    if(item.item.className!=cp){
        item.item.className=cp
        };
        
    if(item.cs!=null&&item.cs.className!=dz){
        item.cs.className=dz
        };
        
    if(item.ct!=null&&item.ct.className!=ea){
        item.ct.className=ea
        };
        
    if(item.fu!=null&&item.fu.className!=fr){
        item.fu.className=fr
        };
        
    if(item.bl.className!=bv){
        item.bl.className=bv
        };
        
    var nw=item.item.offsetWidth,nh=item.item.offsetHeight,dw=item.ow-nw,dh=item.oh-nh;
    if(nw!=item.width||nh!=item.height){
        var dx=gp=="left"?0:gp=="center"?Math.round(dw/2):dw,dy=gt=="top"?0:gt=="middle"?Math.round(dh/2):dh;
        item.x=item.ox+dx;
        item.y=item.oy+dy;
        item.width=nw;
        item.height=nh;
        item.av.width=nw;
        item.av.height=nh;
        yx_ey(item.item,item.x,item.y);
        yx_ey(item.av,item.x,item.y)
        }
    };

function yx_gr(){
    this.go=true;
    if(this.ew){
        this.ch(true)
        }else{
        if(!this.cb){
            this.cb=true;
            yx_ak(this,"dl","()",0,this.cl.cz)
            }
        }
};

function yx_dw(dp){
    this.go=false;
    if(this.fl){
        this.ao();
        if(this.dg!=this.cl||(dp&&!this.cl.gh)){
            yx_dv(this.holder);
            this.fl=false;
            if(this.at!=""){
                eval(this.at)
                }
            };
        
    if(this.dg!=this.cl){
        this.dg.ec()
        }
    }
};

function yx_aw(f){
    if(!yx_ee){
        yx_fl=0;
        yx_az(null);
        if(typeof(f)=="undefined"){
            var cy=null;
            for(var i=0;i<yx_ea.length;i++){
                cy=yx_ea[i];
                if(cy.name!=""&&cy.ge!=null&&cy.ge.event&&cy.ge.event.gg=="click"&&typeof(cy.ge.yx_fn)!="undefined"){
                    cy.ge.yx_fn();
                    return
                }else if(cy.name!=""&&cy.fq!=null&&cy.fq.event&&cy.fq.event.gg=="click"&&typeof(cy.fq.yx_fn)!="undefined"){
                    cy.fq.yx_fn();
                    return
                }
            }
            }
    };

yx_ee=false
};

function yx_ao(h,dp){
    var f=(h.da||dp==1)?(h.ge):(h.fq),gf=false;
    try{
        gf=(f!=null&&"complete,loaded".indexOf(f.document.readyState)!=-1)
        }catch(err){};
    
    return gf
    };
    
function yx_bz(cy){
    if(cy.menu.ew){
        if(cy.gc>0){
            yx_gw(cy.gc);
            cy.gc=-1
            };
            
        yx_at(cy.menu)
        };
        
    cy.menu=new yx_er(cy,cy,cy.au)
    };
    
function yx_by(cy){
    var df=cy.menu.df;
    for(var i=0;i<df.length;i++){
        if(df[i].menu!=null){
            if(df[i].menu.ew){
                yx_at(df[i].menu)
                };
                
            df[i].menu=new yx_er(cy,df[i],df[i].au)
            }
        }
    };

function yx_bx(i){
    if(yx_ea[i].menu.ew){
        if(yx_ea[i].gc>0){
            yx_gw(yx_ea[i].gc)
            };
            
        yx_at(yx_ea[i].menu)
        };
        
    yx_ea[i]={
        name:"",
        menu:{
            ew:false,
            fl:false
        }
    }
};

function yx_fa(x,y){
    yx_ey(this.holder,x,y);
    this.x=x;
    this.y=y
    };
    
function yx_ez(x,y){
    yx_ex(this.holder,x,y);
    this.x+=x;
    this.y+=y
    };
