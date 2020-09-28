Vue.use(vueMoment);

const app = new Vue({

  el: '#keg',
  data : {
        keg: null
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('code')){
      axios
        .get('/keg/'+params.get("code"))
        .then(response => (this.keg = response.data));
    }
  },
  methods: {
    fill: function () {
      axios
        .get('/keg/'+this.keg.id+'/fill')
        .then(response => (this.keg = response.data));
    },
    empty: function () {
      axios
        .get('/keg/'+this.keg.id+'/empty')
        .then(response => (this.keg = response.data));
    }
  }
});


