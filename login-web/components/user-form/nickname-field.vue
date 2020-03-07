<template>
  <div>
    <v-text-field
      :value="value"
      :rules="nicknameRules"
      label="닉네임 입력"
      required
      outlined
      @input="$emit('input',$event)"
    />
  </div>
</template>
<script>
export default {
  props: {
    value: {
      type: String,
      required: true
    }
  },
  data(){
      return {
          nicknameRules: [
              v => !!v || '닉네임을 입력하세요',
              v => (v && v.length > 2) || '2자 이상 입력하세요.',
              v => (v && v.length < 12) || '12자 이상 입력 할 수 없습니다.',
          ]
      }
  },
}
</script>
<style>
  .v-text-field{
    margin-bottom:0 !important
  }
</style>