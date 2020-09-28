Vue.use(vueMoment);

const app = new Vue({

  el: '#keg',
  components: {
  },
  data : {
        beerkit: {}
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('id')){
      axios
        .get('/beerkit/'+params.get("id"))
        .then(response => {
          this.beerkit = response.data;
        });
    }
  },
  methods: {
    save: function () {
      axios
        .post('/beerkit/add', this.beerkit)
        .then(response => {
          this.beerkit = response.data;
          window.location.href='/beerkit-view.html?id='+this.beerkit.id;
        });
    },
    remove: function () {
      axios
        .delete('/beerkit/'+this.beerkit.id)
        .then(response => {
          this.beerkit = {};
          window.location.href='/beerkit-list.html';
        });
    }
  }
});


