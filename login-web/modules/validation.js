export let passwordRules = [
    v => !!v || '비밀번호를 입력하세요',
    v => (v && v.length <= 12) || '비밀번호는 12자리 이하 입니다.',
    v => (v && v.length >= 8) || '비밀번호는 8자리 이상 입니다.',
]

export let emailRules = [
    v => !!v || '이메일을 입력하세요',
    v => /.+@.+\..+/.test(v) || '이메일 형식이 잘못되었습니다.',
]
