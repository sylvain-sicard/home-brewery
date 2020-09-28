Vue.use(vueMoment);

const app = new Vue({
  el: '#table',
  data : { 
        vintages: null
  },
  mounted () {
    axios
      .get('/vintage/all')
      .then(response => {
        this.vintages = response.data;
          $(document).ready(function() {
          $('#dataTable').DataTable();
        });
      });
    
  }
});
