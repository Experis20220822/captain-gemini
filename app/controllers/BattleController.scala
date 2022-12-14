/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package controllers

import play.api.data.Form
import play.api.data.Forms.{mapping, text}
import play.api.i18n.I18nSupport
import play.api.mvc.MessagesControllerComponents
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import views.html.{battle, text_input}

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext


@Singleton class BattleController @Inject()(val mcc: MessagesControllerComponents, view: battle, textInputView: text_input)(implicit val executionContext: ExecutionContext) extends FrontendController(mcc) with I18nSupport {

  case class Data(val field: String) {}

  val form: Form[Data] = Form[Data](
    mapping("field" -> text)(Data.apply)(Data.unapply)
  )

  def index() = Action { implicit request =>
    Ok(view("Battle Time", "Heading", "SomeText"))
  }

  def textInput() = Action {implicit req =>
    Ok(textInputView("", "", ""))
  }
}