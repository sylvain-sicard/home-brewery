Vue.use(vueMoment);

const app = new Vue({

  el: '#wrapper',
  components: {
  	vuejsDatepicker
  },
  data : {
        vintage: {},
        beerKits: {}
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('id')){
      var type  = params.get("vintageType");
      if(this.vintage.vintageType){
        type = this.vintage.vintageType;
      }
      axios
        .get('/'+type+'-vintage/'+params.get("id"))
        .then(response => {
          this.vintage = response.data;
        });
      axios
        .get('/beerkit/all')
        .then(response => {
          this.beerKits = response.data;
        });
    }else{
      axios
        .get('/beerkit/all/available')
        .then(response => {
          this.beerKits = response.data;
        });
    }
    
    
  },
  methods: {
    save: function () { 
      axios
        .post('/'+this.vintage.vintageType+'-vintage/add', this.vintage)
        .then(response => {
          this.vintage = response.data;
          window.location.href='/vintage-view.html?id='+this.vintage.id;
        });
      
    },
    remove: function () {
      axios
        .delete('/'+this.vintage.vintageType+'-vintage/'+this.vintage.id)
        .then(response => {
          this.vintage = {};
          window.location.href='/vintage-list.html';
        });
    }
  }
});


