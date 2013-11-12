/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class TopFollowSetProvider {
	
	public final static org.emftext.language.top.resource.top.ITopExpectedElement TERMINALS[] = new org.emftext.language.top.resource.top.ITopExpectedElement[13];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[12];
	
	public final static org.emftext.language.top.resource.top.mopp.TopContainedFeature[] LINKS = new org.emftext.language.top.resource.top.mopp.TopContainedFeature[90];
	
	public final static org.emftext.language.top.resource.top.mopp.TopContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.language.top.resource.top.mopp.TopContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.language.top.resource.top.mopp.TopExpectedStructuralFeature(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_12_0_0_0);
		TERMINALS[1] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_0_0_0_1_0_0_0);
		TERMINALS[2] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_1_0_0_1_0_0_0);
		TERMINALS[3] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_2_0_0_1_0_0_0);
		TERMINALS[4] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_3_0_0_1_0_0_0);
		TERMINALS[5] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_4_0_0_1_0_0_0);
		TERMINALS[6] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_5_0_0_1_0_0_0);
		TERMINALS[7] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_6_0_0_1_0_0_0);
		TERMINALS[8] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_7_0_0_1_0_0_0);
		TERMINALS[9] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_8_0_0_1_0_0_0);
		TERMINALS[10] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_9_0_0_1_0_0_0);
		TERMINALS[11] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_10_0_0_1_0_0_0);
		TERMINALS[12] = new org.emftext.language.top.resource.top.mopp.TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_11_0_0_1_0_0_0);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.language.top.TopPackage.eINSTANCE.getK().getEStructuralFeature(org.emftext.language.top.TopPackage.K__CHILD);
		FEATURES[1] = org.emftext.language.top.TopPackage.eINSTANCE.getJ().getEStructuralFeature(org.emftext.language.top.TopPackage.J__CHILD);
		FEATURES[2] = org.emftext.language.top.TopPackage.eINSTANCE.getI().getEStructuralFeature(org.emftext.language.top.TopPackage.I__CHILD);
		FEATURES[3] = org.emftext.language.top.TopPackage.eINSTANCE.getH().getEStructuralFeature(org.emftext.language.top.TopPackage.H__CHILD);
		FEATURES[4] = org.emftext.language.top.TopPackage.eINSTANCE.getG().getEStructuralFeature(org.emftext.language.top.TopPackage.G__CHILD);
		FEATURES[5] = org.emftext.language.top.TopPackage.eINSTANCE.getF().getEStructuralFeature(org.emftext.language.top.TopPackage.F__CHILD);
		FEATURES[6] = org.emftext.language.top.TopPackage.eINSTANCE.getE().getEStructuralFeature(org.emftext.language.top.TopPackage.E__CHILD);
		FEATURES[7] = org.emftext.language.top.TopPackage.eINSTANCE.getD().getEStructuralFeature(org.emftext.language.top.TopPackage.D__CHILD);
		FEATURES[8] = org.emftext.language.top.TopPackage.eINSTANCE.getC().getEStructuralFeature(org.emftext.language.top.TopPackage.C__CHILD);
		FEATURES[9] = org.emftext.language.top.TopPackage.eINSTANCE.getB().getEStructuralFeature(org.emftext.language.top.TopPackage.B__CHILD);
		FEATURES[10] = org.emftext.language.top.TopPackage.eINSTANCE.getA().getEStructuralFeature(org.emftext.language.top.TopPackage.A__CHILD);
		FEATURES[11] = org.emftext.language.top.TopPackage.eINSTANCE.getExpr().getEStructuralFeature(org.emftext.language.top.TopPackage.EXPR__CHILD);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[1] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[2] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[3] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[4] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[5] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[6] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[7] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]);
		LINKS[8] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]);
		LINKS[9] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]);
		LINKS[10] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getB(), FEATURES[10]);
		LINKS[11] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getA(), FEATURES[11]);
		LINKS[12] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[13] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[14] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[15] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[16] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[17] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[18] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[19] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]);
		LINKS[20] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]);
		LINKS[21] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]);
		LINKS[22] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getB(), FEATURES[10]);
		LINKS[23] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getA(), FEATURES[11]);
		LINKS[24] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[25] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[26] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[27] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[28] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[29] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[30] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[31] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]);
		LINKS[32] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]);
		LINKS[33] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]);
		LINKS[34] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getB(), FEATURES[10]);
		LINKS[35] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[36] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[37] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[38] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[39] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[40] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[41] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[42] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]);
		LINKS[43] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]);
		LINKS[44] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]);
		LINKS[45] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[46] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[47] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[48] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[49] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[50] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[51] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[52] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]);
		LINKS[53] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]);
		LINKS[54] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[55] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[56] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[57] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[58] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[59] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[60] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[61] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]);
		LINKS[62] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[63] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[64] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[65] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[66] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[67] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[68] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]);
		LINKS[69] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[70] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[71] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[72] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[73] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[74] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]);
		LINKS[75] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[76] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[77] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[78] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[79] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]);
		LINKS[80] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[81] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[82] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[83] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]);
		LINKS[84] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[85] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[86] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]);
		LINKS[87] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
		LINKS[88] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]);
		LINKS[89] = new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[1].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getB(), FEATURES[10]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getA(), FEATURES[11]), });
		TERMINALS[2].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getB(), FEATURES[10]), });
		TERMINALS[3].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getC(), FEATURES[9]), });
		TERMINALS[4].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getD(), FEATURES[8]), });
		TERMINALS[5].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getE(), FEATURES[7]), });
		TERMINALS[6].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getF(), FEATURES[6]), });
		TERMINALS[7].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getG(), FEATURES[5]), });
		TERMINALS[8].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getH(), FEATURES[4]), });
		TERMINALS[9].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getI(), FEATURES[3]), });
		TERMINALS[10].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), FEATURES[2]), });
		TERMINALS[11].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getK(), FEATURES[1]), });
		TERMINALS[12].addFollower(TERMINALS[0], new org.emftext.language.top.resource.top.mopp.TopContainedFeature[] {new org.emftext.language.top.resource.top.mopp.TopContainedFeature(org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(), FEATURES[0]), });
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
