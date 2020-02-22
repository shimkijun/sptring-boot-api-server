<template>
  <div>
    <v-footer
      app
    >
      <chat />

      <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </div>
</template>

<script>
import chat from '~/components/chat.vue'
  export default {
    components:{
      chat,
    },
    data(){
      return {
        footer: {
          inset: false,
        },
      }
    },
  }
</script>