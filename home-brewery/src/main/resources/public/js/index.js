Vue.use(vueMoment);

const app = new Vue({

  el: '#content',
  data : {
        stats: null
  },
  mounted () {
  	axios
      .get('/keg/nb-keg-by-vintage')
      .then(response => {
        this.stats = response.data;
      });
  },
  methods: {
    fill: function () {
     
    }
  }
});


