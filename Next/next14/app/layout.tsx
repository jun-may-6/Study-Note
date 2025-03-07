import { Metadata } from "next"
import Navigations from "../components/navigation"

export const metadata:Metadata = {
  title:{
    template: "%s | Next Movies",
    default: "Next Movies"
  },
  description: 'The best movies on the best framework',
}

let num = 1
let num2 : number = 124124

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body>
        <Navigations />
        {children}
      </body>
    </html>
  )
}
