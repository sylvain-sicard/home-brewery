Vue.use(vueMoment);

const app = new Vue({

  el: '#wrapper',
  data : {
        vintage: {}
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('id')){
      axios
        .get('/Generic-vintage/'+params.get("id"))
        .then(response => {
          this.vintage = response.data;
        });
    
    }
    
  },
  methods: {
    
  }
});


