<template>
  <v-app id="sandbox">
    <default-header />
    <nuxt />
    <default-footer />
  </v-app>
</template>

<script>
import defaultHeader from '~/components/default-header.vue'
import defaultFooter from '~/components/default-footer.vue'

  export default {
    components: {
      defaultHeader,
      defaultFooter,
    },
    data () {
      return {
        
      }
    },
    computed: {
     
    },
    methods: {
  
    }
  }
</script>
<style scoped>
 
</style>