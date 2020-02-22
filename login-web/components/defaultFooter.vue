<template>
  <div>
    <v-footer
      app
    >
      <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        footer: {
          inset: false,
        },
      }
    },
  }
</script>