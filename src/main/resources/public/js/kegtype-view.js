Vue.use(vueMoment);

const app = new Vue({

  el: '#wrapper',
  data : {
        kegtype: null
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('id')){
      axios
        .get('/kegtype/'+params.get("id"))
        .then(response => {
          this.kegtype = response.data;
        });
    
    }
    
  },
  methods: {
    
  }
});


