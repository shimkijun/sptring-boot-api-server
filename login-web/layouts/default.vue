<template>
  <v-app id="sandbox">
    <defaultHeader />
    <nuxt />
    <defaultFooter />
  </v-app>
</template>

<script>
import defaultHeader from '~/components/defaultHeader.vue'
import defaultFooter from '~/components/defaultFooter.vue'
  export default {
    components: {
      defaultHeader,
      defaultFooter
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