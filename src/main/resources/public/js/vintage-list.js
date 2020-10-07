Vue.use(vueMoment);

const app = new Vue({
  el: '#wrapper',
  data : { 
        vintages: null
  },
  mounted () {
    axios
      .get('/Generic-vintage/all')
      .then(response => {
        this.vintages = response.data;
          $(document).ready(function() {
          $('#dataTable').DataTable();
        });
      });
    
  }
});
