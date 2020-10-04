Vue.component('kegtype-select-component',{
  props: ['value'],
  data () {
    return {
      kegTypes : null
    }
  },
  template:`
    <select class="form-control"
      v-bind:value="value"
      v-on:input="$emit('input', $event.target.value)">
      <option v-for="kegType in kegTypes">{{kegType.id}}</option>
    </select>
  `,
  mounted () {
  	axios
      .get('/kegtype/all')
      .then(response => (this.kegTypes = response.data))
  }
})
