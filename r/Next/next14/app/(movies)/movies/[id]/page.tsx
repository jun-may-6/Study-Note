// props 의 타입을 명시하고 구조분해할당을 통해 id를 꺼내온다.
export default function MovieDetail(params){
  let id = params.id
  return <h1>Movie {id}</h1>
}