

const app = new Vue({

  el: '#wrapper',
  data : {
        keg: {},
        vintages: {},
        kegTypes: {}
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('code')){
      axios
        .get('/keg/'+params.get("code"))
        .then(response => {
          this.keg = response.data;
        });
    }

    axios
        .get('/Generic-vintage/all/not-brewed')
        .then(response => {
          this.vintages = response.data;
        });

    axios
        .get('/kegtype/all')
        .then(response => {
          this.kegTypes = response.data;
        });
  },
  methods: {
    save: function () {
      axios
        .post('/keg/add', this.keg)
        .then(response => {
          this.keg = response.data;
          window.location.href='/keg-view.html?code='+this.keg.id;
        });
      
    },
    unregister: function () {
      this.keg.kegType=null;
      this.keg.volume=null;
      axios
        .post('/keg/add', this.keg)
        .then(response => {
          this.keg = response.data;
          window.location.href='/keg-view.html?code='+this.keg.id;
        });
      
    }
  }
});


