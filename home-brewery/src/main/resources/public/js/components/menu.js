Vue.component('menu-component',{
  data () {
    return {
      items : [
        {label:"Beer kits", img:"img/img_wheat-web.png", url:"beerkit-list.html"},
        {label:"Vintages", img:"img/img_beertap-web.png", url:"vintage-list.html"},
        {label:"Kegs", img:"img/img_bottles-web.png", url:"keg-list.html"}
      ]
    }
  },
  template:`
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="menu-component">
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html"> 
      <div class="sidebar-brand-icon "> 
        <img src="img/ic_launcher-web.png" width="50"> 
      </div> 
      <div class="sidebar-brand-text mx-3">Home Brewery</div> 
    </a> 
    <hr class="sidebar-divider my-0"/> 
    <div v-for="item in items">
      <li class="nav-item" :class="isActive(item.url)"> 
        <a class="nav-link" :href="item.url"> 
          <i class="fas fa-fw"> <img :src="item.img" width="25"> </i> 
          <span>{{item.label}}</span> 
        </a> 
      </li> 
      <hr class="sidebar-divider"/> 
    </div> 
  </ul>`,
  methods:{
    isActive: function(url){
      var curUrl = window.location.pathname;

      console.log(url + " : " + curUrl);
      return curUrl == "/"+url ? "active" : ""; 
    }
  }
})
