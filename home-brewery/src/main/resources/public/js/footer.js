Vue.component('footer-component',{
  props: ['items'],
  template:`
      <footer class="sticky-footer bg-white"> 
        <div class="container my-auto"> 
          <div class="copyright text-center my-auto"> 
            <span>Copyright &copy; mssd.fr 2020</span> 
          </div> 
        </div> 
      </footer>`
})

new Vue({
  el: '#footer',
  data:{
    
  }
})
